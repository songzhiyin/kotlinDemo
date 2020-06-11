package com.szy.kotlindemo.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import com.szy.kotlindemo.R
import com.szy.kotlindemo.base.BaseActivity
import com.szy.kotlindemo.dialog.CommonDialog
import com.szy.kotlindemo.dialog.SelectPhotoDialog
import com.szy.kotlindemo.util.ToastUtil
import com.szy.lib.network.Glide.GlideHelper
import com.szy.lib.network.Retrofit.Util.DialogNetUtil
import com.tbruyelle.rxpermissions2.RxPermissions
import kotlinx.android.synthetic.main.activity_take_photo.*
import me.shaohui.advancedluban.Luban
import me.shaohui.advancedluban.OnMultiCompressListener
import org.devio.takephoto.app.TakePhoto
import org.devio.takephoto.app.TakePhoto.TakeResultListener
import org.devio.takephoto.app.TakePhotoImpl
import org.devio.takephoto.model.CropOptions
import org.devio.takephoto.model.InvokeParam
import org.devio.takephoto.model.TContextWrap
import org.devio.takephoto.model.TResult
import org.devio.takephoto.permission.InvokeListener
import org.devio.takephoto.permission.PermissionManager
import org.devio.takephoto.permission.TakePhotoInvocationHandler
import java.io.File


/**
 * 拍照
 */
class TakePhotoActivity : BaseActivity(), TakeResultListener, InvokeListener {
    var rxPermissions: RxPermissions? = null
    private var takePhoto: TakePhoto? = null
    private var invokeParam: InvokeParam? = null
    private var imgHead: ImageView? = null
    override fun getContentId(): Int {
        return (R.layout.activity_take_photo)
    }

    override fun initView() {
        super.initView()
        setTitleName("拍照和相册")
        rxPermissions = RxPermissions(this)
        getTakePhoto()
        imgHead = findViewById(R.id.imgIcon)
    }

    override fun initEvent() {
        super.initEvent()
        setbackListener()
        tvSelectPhoto.setOnClickListener {
            showSelectPhotoDialog()
        }
        tvCallPhone.setOnClickListener {
            RxPermissions(mContext as FragmentActivity).request(android.Manifest.permission.CALL_PHONE)
                ?.subscribe {
                    if (it) {
                        showCallPhoneDialog()
                    } else {
                        ToastUtil.show( "权限没有授权")
                    }
                }
        }
    }

    fun showCallPhoneDialog() {
        var dialog = CommonDialog(mContext!!)
        dialog.setContentMessage("确定拨打10086吗")
        dialog.setonclickConfirm(object : CommonDialog.CallConfirmlistener {
            override fun onClick() {
                val intent = Intent(Intent.ACTION_CALL)
                val data: Uri = Uri.parse("tel:" + 10086)
                intent.data = data
                startActivity(intent)
            }

        })
        dialog.show()

    }

    fun showSelectPhotoDialog() {
        SelectPhotoDialog(mContext!!, object : SelectPhotoDialog.OnClickLisetener {
            override fun onTakePhoto() {//拍照
                val file = File(
                    externalCacheDir,
                    System.currentTimeMillis().toString() + ".png"
                )
                val uri = Uri.fromFile(file)
                getTakePhoto()?.onPickFromCapture(uri)
            }

            override fun onOpenPhoto() {//相册
                val cropOptions =
                    CropOptions.Builder().setAspectX(1).setAspectY(1).setWithOwnCrop(true).create()
                getTakePhoto()?.onPickFromGallery()
            }

        }).show()
    }


    /**
     * 获取TakePhoto实例
     *
     * @return
     */
    fun getTakePhoto(): TakePhoto? {
        if (takePhoto == null) {
            takePhoto =
                TakePhotoInvocationHandler.of(this).bind(TakePhotoImpl(this, this)) as TakePhoto
        }
        return takePhoto
    }

    override fun takeSuccess(result: TResult?) {
        if (result!!.image != null && result.image.originalPath != null) {
            GlideHelper.showImage(mContext, result.image.originalPath, imgHead)
//            lubanPhoto(result.image.originalPath)
        } else {
            ToastUtil.show( "图片获取失败")
        }
    }

    override fun takeCancel() {
    }

    override fun takeFail(result: TResult?, msg: String?) {
    }

    override fun invoke(invokeParam: InvokeParam?): PermissionManager.TPermissionType {
        val type =
            PermissionManager.checkPermission(TContextWrap.of(this), invokeParam!!.method)
        if (PermissionManager.TPermissionType.WAIT == type) {
            this.invokeParam = invokeParam
        }
        return type
    }

    override fun onSaveInstanceState(outState: Bundle) {
        getTakePhoto()?.onSaveInstanceState(outState)
        super.onSaveInstanceState(outState)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        //以下代码为处理Android6.0、7.0动态权限所需
        //以下代码为处理Android6.0、7.0动态权限所需
        val type =
            PermissionManager.onRequestPermissionsResult(requestCode, permissions, grantResults)
        PermissionManager.handlePermissionsResult(mContext, type, invokeParam, this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        getTakePhoto()!!.onActivityResult(requestCode, resultCode, data)
    }

    private fun lubanPhoto(filePath: String) {
        Luban.compress(mContext, File(filePath))
            .putGear(Luban.THIRD_GEAR) // set the compress mode, default is : THIRD_GEAR
            .launch(object : OnMultiCompressListener {
                override fun onStart() {}
                override fun onSuccess(fileList: List<File>) {
                    if (fileList != null && fileList.size > 0) {

                    } else {
                        DialogNetUtil.close_NetworkRequests_diolog()
                    }
                }

                override fun onError(e: Throwable) {
                    ToastUtil.show( "压缩图片失败，请重试")
                }
            })
    }

}
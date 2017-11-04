package com.wonderkiln.camerakit;

import android.support.annotation.Nullable;

import java.io.File;

abstract class CameraImpl {

    protected final EventDispatcher mEventDispatcher;
    protected final PreviewImpl mPreview;

    CameraImpl(EventDispatcher eventDispatcher, PreviewImpl preview) {
        mEventDispatcher = eventDispatcher;
        mPreview = preview;
    }

    abstract void start();
    abstract void stop();

    abstract void setDisplayAndDeviceOrientation(int displayOrientation, int deviceOrientation);

    abstract void setFacing(@Facing int facing);
    abstract void setFlash(@Flash int flash);
    abstract void setFocus(@Focus int focus);
    abstract void setMethod(@CaptureMethod int method);
    abstract void setZoom(@Zoom int zoom);
    abstract void setVideoQuality(@VideoQuality int videoQuality);
    abstract void setVideoBitRate(int videoBitRate);

    abstract void captureImage(ImageCapturedCallback callback);
    interface ImageCapturedCallback {
        void imageCaptured(byte[] jpeg);
    }

    abstract void captureVideo(VideoCapturedCallback callback);
    interface VideoCapturedCallback {
        void videoCaptured(File file);
    }

    abstract void stopVideo();

    abstract Size getCaptureResolution();
    abstract Size getVideoResolution();
    abstract Size getPreviewResolution();
    abstract boolean isCameraOpened();
    abstract boolean frontCameraOnly();

    @Nullable
    abstract CameraProperties getCameraProperties();

}

package com.wonderkiln.camerakit;

import android.support.annotation.NonNull;

public class CameraKitEvent {

    public static final String TYPE_ERROR = "CameraKitError";

    public static final String TYPE_CAMERA_OPEN = "CKCameraOpenedEvent";
    public static final String TYPE_CAMERA_CLOSE = "CKCameraStoppedEvent";

    public static final String TYPE_FACING_CHANGED = "CKFacingChangedEvent";
    public static final String TYPE_FLASH_CHANGED = "CKFlashChangedEvent";

    public static final String TYPE_IMAGE_CAPTURED = "CKVideoCapturedEvent";
    public static final String TYPE_VIDEO_CAPTURED = "CKVideoCapturedEvent";

    private String type;
    private String message;

    private CameraKitEvent() {
    }

    CameraKitEvent(@NonNull String type) {
        this.type = type;
    }

    protected void setMessage(String message) {
        this.message = message;
    }

    @NonNull
    public String getType() {
        return type;
    }

    @NonNull
    public String getMessage() {
        if (message != null) {
            return message;
        }

        return "";
    }

    @Override
    public String toString() {
        return String.format("%s: %s", getType(), getMessage());
    }

}
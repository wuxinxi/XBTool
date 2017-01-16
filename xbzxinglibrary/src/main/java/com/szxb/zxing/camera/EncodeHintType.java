package com.szxb.zxing.camera;

/**
 * 作者：Tangren_ on 2016/12/27 0027.
 * 邮箱：wu_tangren@163.com
 * TODO:用一句话概括
 */


public enum EncodeHintType {
    ERROR_CORRECTION,
    CHARACTER_SET,
    DATA_MATRIX_SHAPE,
    MIN_SIZE,
    MAX_SIZE,
    MARGIN,
    PDF417_COMPACT,
    PDF417_COMPACTION,
    PDF417_DIMENSIONS,
    AZTEC_LAYERS;

    private EncodeHintType() {
    }
}

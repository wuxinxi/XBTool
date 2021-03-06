package com.szxb.api.jni_interface;

/**
 * 作者：Tangren_ on 2017/1/16 16:26.
 * 邮箱：wu_tangren@163.com
 * TODO:一句话描述
 */

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * @author lilei
 * @ClassName: api_interface
 * @Description: 外设api 接口类
 * @date Dec 12, 2016 7:34:51 PM
 */
public class api_interface {

    /**
     * @Fields BIT_WIDTH : 打印机宽的点数
     */
    public static final int BIT_WIDTH = 384;

    /**
     * @Fields WIDTH : 打印机宽的字节数
     */
    private static final int WIDTH = 48;

    /**
     * @Fields GSV_HEAD : 打印图片命令长度
     */
    private static final int GSV_HEAD = 0;

    /**
     * @Fields BUF_LEN : 打印缓冲区大小
     */
    private static final int BUF_LEN = 1024;

    static {
        try {
            System.loadLibrary("HalTransModle");
        } catch (Throwable e) {
            Log.e("jni", "i can't find HalTransModle so!");
            e.printStackTrace();
        }
    }

    static {
        try {
            System.loadLibrary("SeriesCom");
        } catch (Throwable e) {
            Log.e("jni", "i can't find SeriesCom so!");
            e.printStackTrace();
        }
    }

    static {
        try {
            System.loadLibrary("PsamCard");
        } catch (Throwable e) {
            Log.e("jni", "i can't find usbctrl so!");
            e.printStackTrace();
        }
    }

    static {
        try {
            System.loadLibrary("usbctrl");
        } catch (Throwable e) {
            Log.e("jni", "i can't find usbctrl so!");
            e.printStackTrace();
        }
    }

    static {
        try {
            System.loadLibrary("ymodem");
        } catch (Throwable e) {
            Log.e("jni", "i can't find ymodem so!");
            e.printStackTrace();
        }
    }


    /**
     * @param @return
     * @return String    返回类型 ！null 成功
     * @throws
     * @Title: deviceGetVersion
     * @Description: 获取外设软件版本号
     */
    public static native String deviceGetVersion();

    /**
     * @param @return
     * @return byte[]    返回类型
     * @throws
     * @Title: msr_getData
     * @Description: TODO(这里用一句话描述这个方法的作用)
     */
    public static native String[] msr_getData();

    /**
     * @param @return
     * @return int    返回类型 0 成功
     * @throws
     * @Title: printertest
     * @Description: 打印机自检
     */
    public static native int printertest();


    /**
     * @param @param  str 需要打印数据的byte数组
     * @param @param  len byte数组数据长度
     * @param @return
     * @return int    返回类型 0成功
     * @throws
     * @Title: printerdata
     * @Description: 打印数据
     */
    private native static int printerdata(byte[] str, int len);

    /**
     * @param @param  str 需要打印数据的byte数组
     * @param @return
     * @return int    返回类型 0成功
     * @throws
     * @Title: printerStr
     * @Description: 打印字符串
     */
    public static int printerStr(byte[] str) {
        byte[] sendData = new byte[1024];
        int len;
        int len1;
        int i;
        len = str.length / 1024;
        for (i = 0; i < len; i++) {
            System.arraycopy(str, i * 1024, sendData, 0, 1024);
            printerdata(sendData, sendData.length);
        }

        len1 = str.length % 1024;
        System.arraycopy(str, i * 1024, sendData, 0, len1);
        return printerdata(sendData, len1);
    }


    /**
     * @param @param  size 0  1 2 3
     * @param @param  isbold 是否加粗
     * @param @return
     * @return int    返回类型 0成功
     * @throws
     * @Title: printersetfont
     * @Description: 设置打印字体样式
     */
    public static native int printersetfont(byte size, byte isbold);

    /**
     * @param @param  cardType
     * @param @return
     * @return String    返回类型
     * @throws
     * @Title: MifareGetSNR
     * @Description: TODO(这里用一句话描述这个方法的作用)
     */
    public static native String MifareGetSNR(byte[] cardType);

    /**
     * @param @return
     * @return String    返回类型
     * @throws
     * @Title: TypeA_RATS
     * @Description: TODO(这里用一句话描述这个方法的作用)
     */
    public static native String TypeA_RATS();

    /**
     * @param @param  sendApdu
     * @param @return
     * @return String[]    返回类型
     * @throws
     * @Title: RFID_APDU
     * @Description: TODO(这里用一句话描述这个方法的作用)
     */
    public static native String[] RFID_APDU(String sendApdu);

    /**
     * @param @param  nBlock
     * @param @param  keyType
     * @param @param  key
     * @param @return
     * @return int    返回类型
     * @throws
     * @Title: RFIDAuthenCard
     * @Description: TODO(这里用一句话描述这个方法的作用)
     */
    public static native int RFIDAuthenCard(byte nBlock, byte keyType, byte[] key);

    /**
     * @param @param  nBlock
     * @param @param  buf
     * @param @return
     * @return int    返回类型
     * @throws
     * @Title: RFIDReadCard
     * @Description: TODO(这里用一句话描述这个方法的作用)
     */
    public static native int RFIDReadCard(byte nBlock, byte[] buf);

    /**
     * @param @param  nBlock
     * @param @param  buf
     * @param @return
     * @return int    返回类型
     * @throws
     * @Title: RFIDWriteCard
     * @Description: TODO(这里用一句话描述这个方法的作用)
     */
    public static native int RFIDWriteCard(byte nBlock, byte[] buf);

    /**
     * @param @param  nBlock
     * @param @param  nMoney
     * @param @return
     * @return int    返回类型
     * @throws
     * @Title: RFIDInitValue
     * @Description: TODO(这里用一句话描述这个方法的作用)
     */
    public static native int RFIDInitValue(byte nBlock, int nMoney);

    /**
     * @param @param  nBlock
     * @param @param  nMoney
     * @param @return
     * @return int    返回类型
     * @throws
     * @Title: RFIDInctValue
     * @Description: TODO(这里用一句话描述这个方法的作用)
     */
    public static native int RFIDInctValue(byte nBlock, int nMoney);

    /**
     * @param @param  nBlock
     * @param @param  nMoney
     * @param @return
     * @return int    返回类型
     * @throws
     * @Title: RFIDDectValue
     * @Description: TODO(这里用一句话描述这个方法的作用)
     */
    public static native int RFIDDectValue(byte nBlock, int nMoney);

    /**
     * @param @param  nSrcBlock
     * @param @param  nDesBlock
     * @param @return
     * @return int    返回类型
     * @throws
     * @Title: RFIDRestor
     * @Description: TODO(这里用一句话描述这个方法的作用)
     */
    public static native int RFIDRestor(byte nSrcBlock, byte nDesBlock);


    /**
     * @param @param  baud
     * @param @param  slot
     * @param @return
     * @return String    返回类型
     * @throws
     * @Title: psamCardReset
     * @Description: TODO(这里用一句话描述这个方法的作用)
     */
    public static native String psamCardReset(int baud, int slot);

    /**
     * @param @param  slot
     * @param @param  sendApdu
     * @param @return
     * @return String[]    返回类型
     * @throws
     * @Title: psamCardSendAPDUT0
     * @Description: TODO(这里用一句话描述这个方法的作用)
     */
    public static native String[] psamCardSendAPDUT0(int slot, String sendApdu);


    /**
     * @param @param  slot
     * @param @return
     * @return String    返回类型
     * @throws
     * @Title: ICCardPowerOn
     * @Description: TODO(这里用一句话描述这个方法的作用)
     */
    public static native String ICCardPowerOn();


    /**
     * @param @param  slot
     * @param @return
     * @return int    返回类型
     * @throws
     * @Title: ICCardPowerOff
     * @Description: TODO(这里用一句话描述这个方法的作用)
     */
    public static native int ICCardPowerOff();

    /**
     * @param @param  slot
     * @param @param  sendData
     * @param @return
     * @return String[]    返回类型
     * @throws
     * @Title: ICCardSendAPDU
     * @Description: TODO(这里用一句话描述这个方法的作用)
     */
    public static native String[] ICCardSendAPDU(String sendData);


    private static byte[] generateBitmapArrayMSB(Bitmap bm, int bitMarginLeft, int bitMarginTop) {
        byte[] result = null;
        int n = bm.getHeight() + bitMarginTop;
        int offset = GSV_HEAD;
        result = new byte[n * WIDTH + offset];
        for (int y = 0; y < bm.getHeight(); y++) {
            for (int x = 0; x < bm.getWidth(); x++) {
                if (x + bitMarginLeft < BIT_WIDTH) {
                    int color = bm.getPixel(x, y);
                    int alpha = Color.alpha(color);
                    int red = Color.red(color);
                    int green = Color.green(color);
                    int blue = Color.blue(color);
                    if (alpha > 128 && (red < 128 || green < 128 || blue < 128)) {
                        // set the color black
                        int bitX = bitMarginLeft + x;
                        int byteX = bitX / 8;
                        int byteY = y + bitMarginTop;
                        result[offset + byteY * WIDTH + byteX] |= (0x80 >> (bitX - byteX * 8));
                    }
                } else {
                    // ignore the rest data of this line
                    break;
                }
            }
        }
        return result;
    }

    public native static int printBmp(byte[] bmpBuf, int len);

    public static void printBitmap(Bitmap bm, int bitMarginLeft, int bitMarginTop) {
        // TODO Auto-generated method stub
        final int SEND_BUF = 3072;
        byte[] result = generateBitmapArrayMSB(bm, bitMarginLeft, bitMarginTop);

//		 int lines = (result.length - GSV_HEAD) / WIDTH;

        byte[] sendbuf = new byte[SEND_BUF + 3];

        int i;

        for (i = 0; i < result.length / SEND_BUF; i++) {
            sendbuf[0] = (byte) 0x2a;
            sendbuf[1] = (byte) 0x40;
            sendbuf[2] = (byte) 0x30;
            System.arraycopy(result, SEND_BUF * i, sendbuf, 3, SEND_BUF);
            printBmp(sendbuf, sendbuf[1] * sendbuf[2] + 3);
        }

        sendbuf[0] = (byte) 0x2a;
        sendbuf[1] = (byte) ((result.length % SEND_BUF) / 0x30);
        sendbuf[2] = (byte) 0x30;
        System.arraycopy(result, 3072 * i, sendbuf, 3, result.length % SEND_BUF);
        printBmp(sendbuf, sendbuf[1] * sendbuf[2] + 3);

    }

    /**
     * @param @param  cmd
     * @param @return
     * @return int    返回类型
     * @throws
     * @Title: usbopen
     * @Description: TODO(这里用一句话描述这个方法的作用)
     */
    public static native int usbctrl(byte cmd);


    /**
     * @param @param  ass
     * @param @param  filename
     * @param @param  obj_active
     * @param @return
     * @return int    返回类型
     * @throws
     * @Title: ymodemUpdate
     * @Description: TODO(这里用一句话描述这个方法的作用)
     */
    public static native int ymodemUpdate(AssetManager ass, String filename, AppCompatActivity obj_active);

}

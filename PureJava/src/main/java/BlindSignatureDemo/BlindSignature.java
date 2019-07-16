package BlindSignatureDemo;


import java.math.BigInteger;
/**
 * 盲签名相关
 * Created by forest on 2017/5/23.
 */
public class BlindSignature {

    public static void main(String[] args){
        System.out.println("这里是盲签名测试");

        BigInteger e = new BigInteger("32663"); //公开密钥e
        BigInteger d = new BigInteger("23"); //私钥d
        BigInteger n = new BigInteger("42167"); //公开模数n

        BigInteger srcMsg = new BigInteger("123");       //签名的消息
        System.out.println("源消息 = " + srcMsg);

        BigInteger factor = new BigInteger("37");   //盲因子

        BigInteger blindMsg = blindHideMsg(srcMsg, factor, e, n);
        System.out.println("盲化后的消息 = " + blindMsg);

        BigInteger blindSig = blindSignature(blindMsg, d, n);
        System.out.println("包含因子的盲签名 = " + blindSig);

        BigInteger sig = blindRetriveSig(blindSig, factor, n);
        System.out.println("盲签名 = " + sig);

        BigInteger realSig = srcMsg.modPow(d, n);
        System.out.println("原签名 = " + realSig);
    }

    /**盲签名-盲化*/
    public static BigInteger blindHideMsg(BigInteger msg, BigInteger factor, BigInteger e, BigInteger n){
        BigInteger hideMsg = msg.multiply(factor.modPow(e, n)).mod(n);
        return hideMsg;
    }

    /**盲签名-签名*/
    public static BigInteger blindSignature(BigInteger blindMsg, BigInteger d, BigInteger n){
        BigInteger blindSig = blindMsg.modPow(d, n);
        return blindSig;
    }

    /**盲签名-解盲得到签名*/
    public static BigInteger blindRetriveSig(BigInteger blindSig, BigInteger factor, BigInteger n){

        BigInteger signature = blindSig.multiply(factor.modInverse(n)).mod(n);
        return signature;
    }

    /**盲签名-解盲得到签名*/
    public static BigInteger blindRetriveSig1(BigInteger blindSig, BigInteger factor, BigInteger n){

        //        解盲过程应该采用乘法求逆元，而不是除法，
        BigInteger signature = blindSig.divide(factor);
        return signature;
    }
}

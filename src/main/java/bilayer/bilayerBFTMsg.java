package bilayer;

import static constant.ConstantValue.*;

import enums.MessageEnum;
import java.math.BigInteger;

public class bilayerBFTMsg {

    private MessageEnum type;                  // 消息类型
    private int senderId;                      // 发送节点的id
    private BigInteger senderPK;               // 发送节点pk
    private int primeNodeId;                   // 发起请求的节点id
    private String dataHash;                   // 区块的Hash值, 用于标识不同区块
    private Integer b;                         // 输入ABA的值(0, 1, null)
    private long timestamp;                    // 时间戳
    private BigInteger signature;              // 签名
    private boolean isValid;                   // 消息校验是否通过

    public bilayerBFTMsg() {
    }

    public bilayerBFTMsg(MessageEnum type, int senderId) {
        this.type = type;
        this.senderId = senderId;
        this.primeNodeId = senderId;
        this.timestamp = System.currentTimeMillis();
        this.isValid = true;
    }

    // 拷贝
    public bilayerBFTMsg(bilayerBFTMsg msg) {
        this.type = msg.type;
        this.senderId = msg.senderId;
        this.senderPK = msg.senderPK;
        this.primeNodeId = msg.primeNodeId;
        this.dataHash = msg.dataHash;
        this.b = msg.b;
        this.timestamp = msg.timestamp;
        this.signature = msg.signature;
        this.isValid = msg.isValid;
    }

    // 得到消息标识
    public String getMsgKey() {
        return getDataHash() + "|@|" + getSenderId();
    }

    // 获取消息长度
    public long getMsgLen() {
        long len = 0;
        switch (type) {
//            case REQUEST:
//                len =  MSG_TYPE_ID_SIZE + HASH_SIZE + TIMESTAMP_SIZE + ID_SIZE + SIGNATURE_SIZE;
//                break;
//            case PRE_PREPARE:
//                len =  MSG_TYPE_ID_SIZE + VIEW_NO_SIZE + SEQ_NO_SIZE + HASH_SIZE + SIGNATURE_SIZE;
//                break;
//            case PREPARE:
//                len =  MSG_TYPE_ID_SIZE + VIEW_NO_SIZE + SEQ_NO_SIZE + HASH_SIZE + ID_SIZE + SIGNATURE_SIZE;
//                break;
//            case COMMIT:
//                len =  MSG_TYPE_ID_SIZE + VIEW_NO_SIZE + SEQ_NO_SIZE + HASH_SIZE + ID_SIZE + SIGNATURE_SIZE;
//                break;
//            case REPLY:
//                len =  MSG_TYPE_ID_SIZE + VIEW_NO_SIZE + TIMESTAMP_SIZE + ID_SIZE + ID_SIZE + RESULT_SIZE + SIGNATURE_SIZE;
//                break;
            default:
                break;
        }
        return len;
    }

    public MessageEnum getType() {
        return type;
    }

    public void setType(MessageEnum type) {
        this.type = type;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public BigInteger getSenderPK() {
        return senderPK;
    }

    public void setSenderPK(BigInteger senderPK) {
        this.senderPK = senderPK;
    }

    public int getPrimeNodeId() {
        return primeNodeId;
    }

    public void setPrimeNodeId(int primeNodeId) {
        this.primeNodeId = primeNodeId;
    }

    public String getDataHash() {
        return dataHash;
    }

    public void setDataHash(String dataHash) {
        this.dataHash = dataHash;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public BigInteger getSignature() {
        return signature;
    }

    public void setSignature(BigInteger signature) {
        this.signature = signature;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    @Override
    public String toString() {
        return "bilayerBFTMsg {" +
            "isValid=" + isValid +
            ", type=" + type +
            ", primeNodeId=" + primeNodeId +
            ", senderId=" + senderId +
            ", senderPK=" + senderPK +
            ", dataHash='" + dataHash +
            ", b=" + b +
            ", timestamp=" + timestamp +
            ", signature=" + signature + '}';
    }
}

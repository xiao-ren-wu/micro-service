package org.yuwb.rocketmq.listener;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

/**
 * @author WbYu
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * <p>
 * 异步执行本地事务
 * 消息状态检查
 * </p>
 * @version v1.0.0
 * @date 2019/12/31 8:38 上午
 * @since java 11
 */
public class CustomerTransactionListener implements TransactionListener {

    @Override
    public LocalTransactionState executeLocalTransaction(Message message, Object o) {
        return null;
    }

    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
        return null;
    }
}

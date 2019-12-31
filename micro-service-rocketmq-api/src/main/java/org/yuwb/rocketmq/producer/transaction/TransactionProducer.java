package org.yuwb.rocketmq.producer.transaction;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.yuwb.rocketmq.constant.Const;
import org.yuwb.rocketmq.listener.CustomerTransactionListener;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author WbYu
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * <p>
 * </p>
 * @version v1.0.0
 * @date 2019/12/31 8:17 上午
 * @since java 11
 */
public class TransactionProducer {
    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, InterruptedException {
        TransactionMQProducer producer = new TransactionMQProducer("text_tx_producer_group_name");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2000), r -> {
            Thread thread = new Thread(r);
            thread.setName("text_tx_producer_group_name-check_thread");
            return thread;
        });
        producer.setNamesrvAddr(Const.NAMESRV_ADDR_MASTER_SLAVE);
        producer.setExecutorService(threadPoolExecutor);
        producer.setTransactionListener(new CustomerTransactionListener());
        // 启动mq
        producer.start();
        Message message = new Message("test_tx_topic", "TagA", "Key", "hello rocketmq tx".getBytes(RemotingHelper.DEFAULT_CHARSET));
        // 发送消息
        producer.sendMessageInTransaction(message,"我是回调的参数");
        Thread.sleep(Integer.MAX_VALUE);
    }
}

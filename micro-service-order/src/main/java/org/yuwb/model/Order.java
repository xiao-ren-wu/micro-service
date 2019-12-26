package org.yuwb.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuwb
 * @since 2019-12-26
 */
@Data
@Accessors(chain = true)
@TableName("t_order")
public class Order  {


    private String orderId;

    private String orderType;

    private String cityId;

    private String platformId;

    private String userId;

    private String supplierId;

    private String goodsId;

    private String orderStatus;

    private String remark;

    private String createBy;

    private LocalDateTime createTime;

    private String updateBy;

    private LocalDateTime updateTime;


}

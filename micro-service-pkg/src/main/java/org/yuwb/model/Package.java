package org.yuwb.model;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

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
@TableName("t_package")
public class Package  {

    private static final long serialVersionUID=1L;

    private String packageId;

    private String orderId;

    private String supplierId;

    private String addressId;

    private String remark;

    private String packageStatus;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}

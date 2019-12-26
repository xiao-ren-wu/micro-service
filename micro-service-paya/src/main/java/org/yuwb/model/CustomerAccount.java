package org.yuwb.model;

import java.math.BigDecimal;
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
@TableName("t_customer_account")
public class CustomerAccount  {

    private static final long serialVersionUID=1L;

    private String accountId;

    private String accountNo;

    private LocalDateTime dateTime;

    private BigDecimal currentBalance;

    private Integer version;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}

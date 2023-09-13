package com.security.Scheduled;

import lombok.Data;
import org.apache.ibatis.annotations.Param;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * description
 * @author 杨文斌
 */
@Component
@EnableScheduling
public class scheduled {

//    @Scheduled(cron = "0 0 0 */1 * * ")
    @Scheduled(cron = "0 14 16 ? * *")  // 每天下午16点14分执行一次
    public void dingShi() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("定时任务触发");
                System.out.println(new Date());
            }
        }, 0, 1000 * 60 * 60 * 24);//0表示无延迟，一天触发一次
    }
}

/*@Data
public class QuantityAndMoneyDTO {

    // 数量
    private String quantity;

    // 金额
    private String money;

}*/

// 传清单集合 查询合同数量
 /*   QuantityAndMoneyDTO sumContractQuantity(@Param("inventory") List<String> inventory);

<resultMap type="com.kingroad.progress.domain.DTO.QuantityAndMoneyDTO" id="QuantityAndMoneyMap">
<result property="quantity" column="inventory_check_revision"/>
<result property="money" column="price"/>
</resultMap>

<select id="sumContractQuantity" resultMap="QuantityAndMoneyMap">
        SELECT
        sum(inventory_check_revision) as inventory_check_revision,
        sum(inventory_check_revision*unit_price) as price
        FROM tb_production_value_plan where inventory_code in
<foreach item="inventory" collection="inventory" open="(" separator="," close=")">
        #{inventory}
        </foreach>
        </select>*/


    /*// 传清单集合 查询合同数量, 合同总金额
    QuantityAndMoneyDTO sumContractQuantity(List<String> inventorys);

    // 传清单集合  查询本月计划总量,总金额
    BigDecimal sumMonthPlan(List<String> inventory);




    // 传清单集合 查询本月实际量,总金额
    BigDecimal sumMonthActual(List<String> inventory);*/

    // 传清单集合 查询合同数量, 合同总金额
/*    @Override
    public QuantityAndMoneyDTO sumContractQuantity(List<String> inventory) {
        return tbProductionValuePlanMapper.sumContractQuantity(inventory);
    }

    // 传清单集合  查询本月计划总量,总金额
    @Override
    public BigDecimal sumMonthPlan(List<String> inventory) {
        List<String> time = getTime();




        return null;
    }

    // 传清单集合 查询本月实际量,总金额
    @Override
    public BigDecimal sumMonthActual(List<String> inventory) {
        return null;
    }*/

    // 获取本月的1号到31号
  /*  public List<String> getTime(){
        List<String> list = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        String startTime = "";
        String endTime = "";
        if (month < 10){
            startTime = year + "-" + "0" + month + "-01";
            endTime = year + "-" + "0" + month + "-31";
        } else {
            startTime = year + "-" + month + "-01";
            endTime = year + "-" + month + "-31";
        }
        list.add(startTime);
        list.add(endTime);
        return list;
    }*/
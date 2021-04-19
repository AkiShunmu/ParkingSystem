package com.education.shun.Service;

import com.education.shun.entity.ParkFee;

import java.util.List;

/**
 * @program: ParkingSystem
 * @description: 费用信息业务接口
 * @author: qishun zhou
 * @create: 2021-04-19 11:08
 **/

public interface IParkFeeService {

    List<ParkFee> plateFind(String plate);

    List<ParkFee> userFeeFind(String userId);

    boolean feeInsert(String parkId, String userId, String plate, Integer parkTime, Integer fee);

}

package com.education.shun.Service.Impl;

import com.education.shun.Service.IParkFeeService;
import com.education.shun.dao.ParkFeeMapper;
import com.education.shun.entity.ParkFee;

import java.util.List;

/**
 * @program: ParkingSystem
 * @description: 费用信息实现类
 * @author: qishun zhou
 * @create: 2021-04-19 11:09
 **/

public class ParkFeeServiceImpl implements IParkFeeService {

    private ParkFeeMapper parkFeeMapper = new ParkFeeMapper();

    @Override
    public List<ParkFee> plateFind(String plate) {
        return parkFeeMapper.plateFind(plate);
    }

    @Override
    public List<ParkFee> userFeeFind(String userId) {
        return parkFeeMapper.userFeeFind(userId);
    }

    @Override
    public boolean feeInsert(String parkId, String userId, String plate, Integer parkTime, Integer fee) {
        return parkFeeMapper.feeInsert(parkId, userId, plate, parkTime, fee);
    }
}

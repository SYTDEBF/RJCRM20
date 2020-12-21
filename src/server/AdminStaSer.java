package server;

import dto.DataCouDto;

import java.util.List;

public interface AdminStaSer {

    /**
     * 获取员工总数
     * @return
     */
    public List<DataCouDto> getAllCou();
}

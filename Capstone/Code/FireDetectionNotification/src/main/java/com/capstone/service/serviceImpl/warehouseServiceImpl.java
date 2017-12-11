package com.capstone.service.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.Model.JqGrid.JqGridData;
import com.capstone.dao.warehouseDAO;
import com.capstone.service.warehouseService;

@Service("warehouseService")
public class warehouseServiceImpl implements warehouseService {

	@Autowired
	warehouseDAO warehouseDAO;

	@Override
	public List warehouseSelectAll() {
		// TODO Auto-generated method stub
		return warehouseDAO.warehouseSelectAll();
	}

	@Override
	public void Save(List<Map> listMap) {
		// TODO Auto-generated method stub

		for (int i = 0; i < listMap.size(); i++) {
			Map<String, Object> map = listMap.get(i);
			String status = map.get("flag").toString();
			if (status.equals(JqGridData.STATUS_INSERT)) {
				warehouseDAO.InsertWarehouse(map);
			} else if (status.equals(JqGridData.STATUS_UPDATE)) {
				warehouseDAO.UpdateWarehouse(map);
			} else if (status.equals(JqGridData.STATUS_DELETE)) {
				System.out.println("D " + map.get(i));
				warehouseDAO.DeleteWarehouse(map);
			}
		}
	}
	@Override
	public List<Map> warehouseAdmin(int adminidx) {
		// TODO Auto-generated method stub
		return warehouseDAO.warehouseAdmin(adminidx);
	}
}

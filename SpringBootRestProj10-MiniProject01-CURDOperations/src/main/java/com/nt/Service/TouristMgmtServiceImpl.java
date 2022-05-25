package com.nt.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Tourist;
import com.nt.exception.TouristNotFoundException;
import com.nt.repo.ITouristRepo;

@Service("touristService")
public class TouristMgmtServiceImpl implements ITouristMgmtService {

	@Autowired
	private ITouristRepo touristRepo;

	@Override
	public String registerTourist(Tourist tourist) {
		int idVal = touristRepo.save(tourist).getTid();
		return "Tourist is registered having the id value:::" + idVal;
	}

	@Override
	public List<Tourist> fetchAllTourist() {
		List<Tourist> list = touristRepo.findAll();
		list.sort((t1,t2) -> t1.getTid().compareTo(t2.getTid()));
		return list;
	}

	@Override
	public Tourist fetchTouristById(Integer tid) throws TouristNotFoundException {
		
		return touristRepo.findById(tid).orElseThrow(() -> new TouristNotFoundException(tid+"torist not found"));
	}
}

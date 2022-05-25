package com.nt.Service;

import java.util.List;
import java.util.Optional;

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
		list.sort((t1, t2) -> t1.getTid().compareTo(t2.getTid()));
		return list;
	}

	@Override
	public Tourist fetchTouristById(Integer tid) throws TouristNotFoundException {

		return touristRepo.findById(tid).orElseThrow(() -> new TouristNotFoundException(tid + "torist not found"));
	}

	@Override
	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException {

		Optional<Tourist> optional = touristRepo.findById(tourist.getTid());
		if (optional.isPresent()) {
			touristRepo.save(tourist); // save(-) performs either save obj or update obj operation
			return tourist.getTid() + "Tourist is updated";
		}
		else {
			throw new TouristNotFoundException(tourist.getTid()+"Tourist Not Found");
		}
	}

	
	@Override
	public String deleteTourist(Integer tid) throws TouristNotFoundException {
		Optional<Tourist> opt = touristRepo.findById(tid);
		if(opt.isPresent()) {
			touristRepo.delete(opt.get());
			return tid+ "Tourist deleted";
		}
		else {
			throw new TouristNotFoundException(tid+"Tourist not found");
		}
		
	}
}

package net.tfedu.zhl.cloud.resource.customizeres.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.tfedu.zhl.cloud.resource.asset.entity.ZAssetView;
import net.tfedu.zhl.cloud.resource.customizeres.dao.CustomizeResMapper;
import net.tfedu.zhl.cloud.resource.customizeres.entity.CustomizeResResult;
import net.tfedu.zhl.cloud.resource.customizeres.service.CustomizeResService;
import net.tfedu.zhl.sso.subject.entity.JSubject;


@Service("customizeResService")
public class CustomizeResServiceImpl implements CustomizeResService {

	@Autowired
	CustomizeResMapper mapper;
	
	
	


	@Override
	public List<CustomizeResResult> getCustomizeResResult() {

		List<JSubject> subjectList = mapper.getAllSubject();
		if(subjectList!=null && subjectList.size()>0){
			List<CustomizeResResult> resultList = new ArrayList<CustomizeResResult>();
			for (int i = 0; i < subjectList.size(); i++) {
				JSubject s = subjectList.get(i);
				List<ZAssetView> list = mapper.getCustomizeResResult(s.getCode()); 
				CustomizeResResult rs = new CustomizeResResult();
				rs.setSubject(s);
				rs.setList(list);
				resultList.add(rs);
			}
			return resultList;
		}
		return null;
	}

}

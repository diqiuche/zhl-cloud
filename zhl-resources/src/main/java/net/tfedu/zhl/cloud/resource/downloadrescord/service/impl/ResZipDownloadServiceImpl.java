package net.tfedu.zhl.cloud.resource.downloadrescord.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.tfedu.zhl.cloud.resource.downloadrescord.dao.ResDownRecordMapper;
import net.tfedu.zhl.cloud.resource.downloadrescord.dao.ResZipDownRecordMapper;
import net.tfedu.zhl.cloud.resource.downloadrescord.entity.ResDownRecord;
import net.tfedu.zhl.cloud.resource.downloadrescord.entity.ResZipDownRecord;
import net.tfedu.zhl.cloud.resource.downloadrescord.service.ResZipDownloadService;
import net.tfedu.zhl.cloud.resource.prepare.entity.JPrepareContentView;
import net.tfedu.zhl.cloud.resource.resourceList.entity.PageInfoToPagination;
import net.tfedu.zhl.cloud.resource.resourceList.entity.Pagination;
import net.tfedu.zhl.cloud.utils.datatype.StringUtils;
import net.tfedu.zhl.core.exception.ParamsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

@Service("resZipDownloadService")
public class ResZipDownloadServiceImpl implements ResZipDownloadService {

	@Autowired
	ResZipDownRecordMapper mapper;

	@Autowired
	ResDownRecordMapper mapper1;

	@Override
	public void addZipDownRecord(ResZipDownRecord obj)    throws Exception
 {

		String resIds = obj.getIds();
		String fromflags = obj.getFromflags();
		if (StringUtils.isNotEmpty(resIds) && StringUtils.isNotEmpty(fromflags)) {
			String ids[] = resIds.split(",");
			String flags[] = fromflags.split(",");
			if (ids.length != flags.length) {
				throw new ParamsException();
			}
			List<ResDownRecord> list = new ArrayList<ResDownRecord>();
			Calendar c = Calendar.getInstance();
			for (int i = 0; i < flags.length; i++) {
				ResDownRecord r = new ResDownRecord();
				r.setResid(Long.parseLong(ids[i]));
				r.setFromflag(Integer.parseInt(flags[i]));
				r.setDowndate(c.getTime());
				r.setDowntime(c.getTime());
				r.setUserid(obj.getUserid());
				list.add(r);
			}
			mapper1.insertList(list);
		}
		mapper.insert(obj);
	}

	@Override
	public void updateZipDownRecord(ResZipDownRecord obj) {
		mapper.updateByPrimaryKeySelective(obj);
	}

	@Override
	public ResZipDownRecord getZipDownRecord(Long id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public Pagination getMydownload(Long userId, Long unifyTypeId,
			String fileFormat, Integer page, Integer prePage) {
		PageHelper.startPage(page, prePage);
		List<JPrepareContentView> list = mapper.getMydownload(userId,
				unifyTypeId, fileFormat);
		Pagination p = new PageInfoToPagination().transfer(list);
		return p;
	}

	@Override
	public void AddDownRecordList(List<ResDownRecord> list) {
		mapper1.insertList(list);
	}

}
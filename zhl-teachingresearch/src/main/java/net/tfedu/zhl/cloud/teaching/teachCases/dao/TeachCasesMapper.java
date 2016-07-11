package net.tfedu.zhl.cloud.teaching.teachCases.dao;

import java.util.List;

import net.tfedu.zhl.cloud.teaching.teachCases.entity.TCaseContents;
import net.tfedu.zhl.cloud.teaching.teachCases.entity.TeachCases;
import net.tfedu.zhl.helper.CoreMapper;

import org.apache.ibatis.annotations.Param;

public interface TeachCasesMapper extends CoreMapper<TeachCases> {
	
	/**
	 * 查询所有的教学案例
	 * @return
	 */
	public List<TeachCases> selectAllCases(@Param("fromFlag")int fromFlag,@Param("termId")int termId,@Param("subjectId")int subjectId);

	/**
	 * 新建一个教学案例
	 * @param teachCase  新增教学案例的详细信息
	 */
    public void addOneTeachCase(@Param("teachCase")TeachCases teachCase);
    
    /**
     * 编辑一个教学案例
     * @param teachCase  编辑的教学案例的详细信息
     */
    public void editOneTeachCase(@Param("teachCase")TeachCases teachCase);
    
    /**
     * 删除一个教学案例
     * @param id  教学案例的id
     */
    public void deleteOneTeachCase(@Param("id")long id);
    
    /**
     * 查询一个教学案例的详细信息
     * @param id  教学案例的id
     * @return
     */
    public TeachCases selectOneTeachCase(@Param("id")long id);
    
    /**
     * 查询一个教学案例下的所有内容
     * @param id 教学案例的id
     * @return
     */
    public List<TCaseContents> getAllContentsOfTeachCase(@Param("id")long id);
    
    /**
     * 查询教学案例下是否已经存在相应类型的内容
     * @param typeId  内容id
     * @param caseId  教学案例id
     * @return
     */
    public int selectOneContent(@Param("typeId")int typeId,@Param("caseId")long caseId);
    
    /**
     * 增加一个新内容
     * @param caseId
     * @param typeId
     * @param fname
     */
    public void addOneContent(@Param("caseId")long caseId,@Param("typeId")int typeId,@Param("fname")String fname,@Param("title")String
    		 title,@Param("userId")long userId);
    
    /**
     * 删除教学案例下的一个内容
     * @param caseId  案例id
     * @param typeId  内容类型id（一个内容对应一个类型）
     */
    public void deleteOneContent(@Param("id")long id);
}
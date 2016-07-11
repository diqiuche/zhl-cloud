package net.tfedu.zhl.cloud.resource.navigation.dao;

import java.util.HashMap;
import java.util.List;

import net.tfedu.zhl.cloud.resource.navigation.entity.CourseViewTk;
import net.tfedu.zhl.cloud.resource.navigation.entity.JSyscourse;
import net.tfedu.zhl.cloud.resource.navigation.entity.KonwladgeViewTk;
import net.tfedu.zhl.cloud.resource.navigation.entity.TreeNode;
import net.tfedu.zhl.helper.CoreMapper;

import org.apache.ibatis.annotations.Param;

/**
 * 根据学段、学科，获得所有教材版本
 * 
 * @author WeiCuicui
 *
 */
public interface JSyscourseMapper extends CoreMapper<JSyscourse> {

    /**
     *  根据学段、学科，获得所有教材版本
     * @param map
     * @return
     */
    public List<JSyscourse> getAllEditions(HashMap<String, Object> map);

    
    /**
     *  根据学段、学科，获得所有教材版本（教材name保留学段学科）
     * @param map
     * @return
     */
    public List<JSyscourse> getAllEditions2(HashMap<String, Object> map);
    
    /**
     *  根据所属版本和产品编码，查询所有的教材
     * @param map
     * @return
     */
    public List<JSyscourse> getAllBooks(HashMap<String, Object> map);

    /**
     *  根据父结点id，查询子结点
     * @param pnodeId
     * @return
     */
    public List<TreeNode> getTopChildrenResultMap(long pnodeId);
    
    /**
     * 根据课程结点id，获取课程的详细信息
     * @param id
     * @return
     */
    public List<TreeNode> getOneCourseInfo(@Param("id")long id,@Param("proCode")String proCode);
    
    
    
    /**
     * 根据教程结点tfcode，获取全部节点的详细信息
     * @param tfcode
     * @param proCode
     * @return
     */
    public List<CourseViewTk> getAllCourseTreeInfo(@Param("tfcode")String tfcode,@Param("proCode")String proCode);
    
    
    /**
     * 获取具体的版本下的教材
     * @param tfcode
     * @param proCode
     * @return
     */
    public List<String> getProductTfcode(@Param("tfcode")String tfcode,@Param("proCode")String proCode);
    
    
    /**
     * 获取学段、学科下的知识点(部分)
     * @param term_id
     * @param subj_id
     * @return
     */
    public List<KonwladgeViewTk> getKnowladgeTree(@Param("term_id")String term_id,@Param("subj_id")String subj_id);
    
    
    
}
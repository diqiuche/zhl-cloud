package net.tfedu.zhl.sso.subject.dao;

import net.tfedu.zhl.helper.CoreMapper;
import net.tfedu.zhl.sso.subject.entity.JTeacherSubject;

public interface JTeacherSubjectMapper extends CoreMapper<JTeacherSubject> {

    /**
     * 更新用户的学科（教师）
     * 
     * @param userId
     * @param subjectId
     */
    public void udpateTeacherSubject(Long userId, Long subjectId);

    /**
     * 清理（用户的学科）重复记录
     * 
     * @param userId
     */
    public void removeRepeatData(Long userId);

}
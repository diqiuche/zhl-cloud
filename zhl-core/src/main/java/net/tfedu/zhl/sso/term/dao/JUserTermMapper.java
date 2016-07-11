package net.tfedu.zhl.sso.term.dao;

import net.tfedu.zhl.helper.CoreMapper;
import net.tfedu.zhl.sso.term.entity.JUserTerm;

public interface JUserTermMapper extends CoreMapper<JUserTerm> {

    public void updateUserTerm(Long userId, Long termId);
}
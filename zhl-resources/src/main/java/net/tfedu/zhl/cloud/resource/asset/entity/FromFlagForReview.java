package net.tfedu.zhl.cloud.resource.asset.entity;

/**
 * 新版资源中心中前端的fromflag 和 评论表中的AType 有差异
 * 
 * 转换 前端的fromflag:0，系统资源，1自建资源，2共享资源,3校本资源,4区本资源 评论表中的AType:0
 * 共享资源评论,1系统资源评论,2自建资源, 3,4校区本资源评论
 * 
 * @author wangwr
 *
 */
public class FromFlagForReview {

    /**
     * 
     * @param fromFlag
     *            前端的fromflag:0，系统资源，1自建资源，2共享资源,3校本资源,4区本资源
     * @return 评论表中的AType
     * 
     */
    public static int getAtypeByFromFlag(Integer fromFlag) {
        switch (fromFlag) {
        case 0:
            return 1;
        case 1:
            return 2;
        case 2:
            return 0;
        case 3:
            return 3;
        case 4:
            return 4;
        default:
            return 1;// 其他情况认为是自建资源
        }
    }

}

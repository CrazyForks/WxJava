package me.chanjar.weixin.channel.api;

import java.io.File;
import java.util.List;
import me.chanjar.weixin.channel.bean.audit.AuditApplyResponse;
import me.chanjar.weixin.channel.bean.audit.AuditResponse;
import me.chanjar.weixin.channel.bean.base.WxChannelBaseResponse;
import me.chanjar.weixin.channel.bean.category.CategoryDetailResult;
import me.chanjar.weixin.channel.bean.category.CategoryQualificationResponse;
import me.chanjar.weixin.channel.bean.category.PassCategoryResponse;
import me.chanjar.weixin.channel.bean.category.ShopCategory;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 视频号小店 商品类目相关接口
 *
 * @author <a href="https://github.com/lixize">Zeyes</a>
 */
public interface WxChannelCategoryService {

  /**
   * 获取所有的类目
   *
   * @return 所有类目以及资质信息
   *
   * @throws WxErrorException 异常
   */
  CategoryQualificationResponse listAllCategory() throws WxErrorException;

  /**
   * 获取商品类目列表(全量) 有频率限制
   *
   * @param parentId 类目父id
   * @return 类目列表
   *
   * @throws WxErrorException 异常
   */
  List<ShopCategory> listAvailableCategory(String parentId) throws WxErrorException;

  /**
   * 获取类目信息
   *
   * @param id 三级类目id
   * @return 类目信息
   *
   * @throws WxErrorException 异常
   */
  CategoryDetailResult getCategoryDetail(String id) throws WxErrorException;

  /**
   * 上传类目资质
   *
   * @param level1      一级类目ID
   * @param level2      二级类目ID
   * @param level3      三级类目ID
   * @param certificate 资质材料，图片mediaid，图片类型，最多不超过10张
   * @return 审核id
   *
   * @throws WxErrorException 异常
   * @see WxChannelBasicService#uploadQualificationFile(File)
   */
  AuditApplyResponse addCategory(String level1, String level2, String level3, List<String> certificate)
    throws WxErrorException;

  /**
   * 取消类目提审
   *
   * @param auditId 提交审核时返回的id
   * @return BaseResponse
   *
   * @throws WxErrorException 异常
   */
  WxChannelBaseResponse cancelCategoryAudit(String auditId) throws WxErrorException;

  /**
   * 查询类目审核结果
   *
   * @param auditId 审核id
   * @return 审核结果
   *
   * @throws WxErrorException 异常
   */
  AuditResponse getAudit(String auditId) throws WxErrorException;

  /**
   * 获取账号申请通过的类目和资质信息
   *
   * @return 类目和资质信息
   *
   * @throws WxErrorException 异常
   */
  PassCategoryResponse listPassCategory() throws WxErrorException;
}

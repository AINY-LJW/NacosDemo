/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2012
 * 包： com.comment.test.feginclient
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年10月16日       lijiawen        
 * ============================================================*/

package com.comment.test.feginclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>TODO 类描述</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2008<br>
 * Company: 久其</p>
 *
 * @author lijiawen
 * @version 2019年10月16日
 */

@FeignClient(name = "commentAnalysis-provider",fallback = RemoteHystrix.class)
public interface RemoteClient {

    @GetMapping("/user/getStatistics")
    String helloNacos();
}

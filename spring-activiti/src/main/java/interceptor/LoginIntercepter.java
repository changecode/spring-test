package interceptor;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 拦截用户是否登录
 *
 */
public class LoginIntercepter extends HandlerInterceptorAdapter{
	/**  
     * 在业务处理器处理请求之前被调用及其执行顺序
     * 
     * false -> afterCompletion ->  退出拦截器
     *
     *	true -> 依次执行下一个拦截器  -> 执行被拦截的Controller -> 进入拦截器链  -> 最后一个拦截器往回执行所有的postHandle() -> 再从最后一个拦截器往回执行所有的afterCompletion()
     *    
     *    未登录跳转至登录页面
     */    
    @Override    
    public boolean preHandle(HttpServletRequest request,    
            HttpServletResponse response, Object handler) throws Exception {    
        String username =  (String)request.getSession().getAttribute("username");   
        if(username == null){  
            request.getRequestDispatcher("/WEB-INF/content/login.jsp").forward(request, response);  
            return false;  
        }else  
            return true;     
    }    
    
    /** 
     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作 ;可在modelAndView中加入数据，比如当前时间 
     */  
    @Override    
    public void postHandle(HttpServletRequest request,    
            HttpServletResponse response, Object handler,    
            ModelAndView modelAndView) throws Exception {     
    }    
    
    /**  
     * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等   
     *   
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()  
     */    
    @Override    
    public void afterCompletion(HttpServletRequest request,    
            HttpServletResponse response, Object handler, Exception ex)    
            throws Exception {    
    }    
  
}

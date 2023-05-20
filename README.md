# spring-security-demo
Spring Security Demo， include authentication, and authorization.

包含登录鉴权、以及权限控制。
权限控制，在启动类加上注解：@EnableMethodSecurity，需要控制权限的方法上增加注解，例如：@PreAuthorize("hasAuthority('user:read')"), 在UserDetailsServiceImpl的loadUserByUsername方法中设置权限。

import ru.mm2.operations.SecRole
import ru.mm2.operations.SecUser
import ru.mm2.operations.SecUserSecRole

class BootStrap {
    def springSecurityService
    def init = { servletContext ->
        def userRole = SecRole.findByAuthority('ROLE_OPER') ?: new SecRole(authority: 'ROLE_OPER').save(failOnError: true)
        def adminRole = SecRole.findByAuthority('ROLE_ROOT') ?: new SecRole(authority: 'ROLE_ROOT').save(failOnError: true)
        def adminUser = SecUser.findByUsername('webroot') ?: new SecUser(
                username: 'webroot',
                password: springSecurityService.encodePassword('Tie2Fighter'),
                enabled: true).save(failOnError: true)

        if (!adminUser.authorities.contains(adminRole)) {
            SecUserSecRole.create adminUser, adminRole
        }
    }
    def destroy = {
    }
}

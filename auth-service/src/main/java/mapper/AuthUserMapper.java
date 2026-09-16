package mapper;

import dto.request.RegisterRequest;
import entity.AuthUser;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AuthUserMapper {
    AuthUser toEntity(RegisterRequest request);
}

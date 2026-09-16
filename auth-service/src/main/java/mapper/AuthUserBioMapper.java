package mapper;

import dto.request.RegisterRequest;
import entity.AuthUserBio;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AuthUserBioMapper {
    AuthUserBio toEntity(RegisterRequest request);
}

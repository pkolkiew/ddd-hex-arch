package pl.pkolkiew.dddhexarch.model.user.domain;

import pl.pkolkiew.dddhexarch.model.user.domain.dto.UserTypeDto;

import java.math.BigDecimal;

/**
 * @author pkolkiew
 * Created 20.07.2019
 */
enum UserType {

    COMMON(5D), VIP(2D), PRESIDENT(0D);

    private BigDecimal provision;

    UserType(Double provision) {
        this(BigDecimal.valueOf(provision));
    }

    UserType(BigDecimal provision) {
        this.provision = provision;
    }

    // TODO add this to User/Dto
    UserTypeDto dto(){
        return UserTypeDto.valueOf(name());
    }
}

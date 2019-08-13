package pl.pkolkiew.dddhexarch.user.domain;

import pl.pkolkiew.dddhexarch.user.dto.UserTypeDto;

import java.math.BigDecimal;

/**
 * @author pkolkiew
 * Created 20.07.2019
 */
enum UserType {

    COMMON(7D), VIP(3D), PRESIDENT(1D);

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

package cn.kspshare.validation;

import cn.kspshare.dto.request.KspUserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        KspUserDto user = (KspUserDto) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}

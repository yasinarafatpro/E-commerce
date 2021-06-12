package com.example.demo.validator;

import com.example.demo.form.CustomerForm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CustomerFormValidator implements Validator{
    private EmailValidator emailValidator;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz== CustomerForm.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerForm custInfo=(CustomerForm)target;
        //check the fields of productForm
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"code","NotEmpty.productForm.code");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","NotEmpty.productForm.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"price","NotEmpty.productForm.price");

        if (emailValidator.isValid(custInfo.getEmail())){
            errors.rejectValue("email","Pattern.customerForm.email");
        }
    }
}

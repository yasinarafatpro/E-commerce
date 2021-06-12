package com.example.demo.validator;

import com.example.demo.form.CustomerForm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerFormValidator implements Validator{
    private EmailValidator emailValidator;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz== CustomerForm.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerForm customerForm=(CustomerForm)target;
    }

    
}

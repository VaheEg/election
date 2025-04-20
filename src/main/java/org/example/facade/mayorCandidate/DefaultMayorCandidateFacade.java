package org.example.facade.mayorCandidate;

import lombok.RequiredArgsConstructor;
import org.example.domain.entity.MayorCandidate;
import org.example.domain.response.GenericResponseDto;
import org.example.domain.response.mayorCandidate.MayorCandidateResponseDto;
import org.example.error.Error;
import org.example.facade.mayorCandidate.mapping.MayorCandidateMapping;
import org.example.facade.mayorCandidate.validate.MayorCandidateValidation;
import org.example.service.mayorCandidate.MayorCandidateService;
import org.example.service.mayorCandidate.params.CreateMayorCandidateParams;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultMayorCandidateFacade implements MayorCandidateFacade {

    private final MayorCandidateValidation mayorCandidateValidation;
    private final MayorCandidateService mayorCandidateService;
    private final MayorCandidateMapping mayorCandidateMapping;

    @Override
    public GenericResponseDto<MayorCandidateResponseDto> create(Integer userId) {

        var createValidatedOptional = mayorCandidateValidation.createValidate(userId);
        if(createValidatedOptional.isPresent()){
            return new GenericResponseDto<>(createValidatedOptional.get());
        }

        Optional<MayorCandidate> mayorCandidateOptional = mayorCandidateService.create(new CreateMayorCandidateParams(userId));
        if(mayorCandidateOptional.isEmpty()) {
            Error error = Error.NOT_FOUND;
            error.setMessage("User not found for creating Mayor candidate");

            return new GenericResponseDto<>(error);
        }

        var responseDto = mayorCandidateMapping.doMap(mayorCandidateOptional.get());

        return new GenericResponseDto<>(responseDto);
    }

    @Override
    public GenericResponseDto<MayorCandidateResponseDto> getById(Integer id) {

        var getByIdValidatedOptional = mayorCandidateValidation.getValidate(id);
        if(getByIdValidatedOptional.isPresent()) {
            return new GenericResponseDto<>(getByIdValidatedOptional.get());
        }

        var mayorCandidateOptional = mayorCandidateService.getById(id);
        if(mayorCandidateOptional.isEmpty()) {
            Error error = Error.NOT_FOUND;
            error.setMessage("Mayor candidate not found");
            return new GenericResponseDto<>(error);
        }
        var responseDto = mayorCandidateMapping.doMap(mayorCandidateOptional.get());

        return new GenericResponseDto<>(responseDto);
    }

    @Override
    public GenericResponseDto<List<MayorCandidateResponseDto>> getAll() {

        var mayorCandidates = mayorCandidateService.getAll();
        var responseDto = mayorCandidateMapping.getAllMap(mayorCandidates);

        return new GenericResponseDto<>(responseDto);
    }

    @Override
    public GenericResponseDto<Void> deleteById(Integer id) {

        return mayorCandidateValidation.deleteValidate(id);
    }
}

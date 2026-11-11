package com.practice.kino.service;

import com.practice.kino.dto.request.UpdateBioRequest;
import com.practice.kino.dto.response.BioReadResponse;

import java.util.UUID;

public interface UserBioService {
    void updateUserBio(UUID id, UpdateBioRequest request);
    BioReadResponse findByUserId(UUID id);
    BioReadResponse findById(UUID id);
}

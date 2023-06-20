package com.works.controllers;

import com.works.entities.UseCode;
import com.works.services.TinkEncDec;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class DashboardController {

    final TinkEncDec tinkEncDec;

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @PostMapping("/codeSave")
    public String codeSave(UseCode code) {
        String cipherText = tinkEncDec.encrypt(code.getPlainText(), code.getUseKey());
        System.out.println(cipherText);

        String plainText = tinkEncDec.decrypt("fMKJJmzDtcOow5pZd8Ktw6DDp8K9QRDDiH3CmCFNfsOVw507wrnDhnPCosKBDsO9flQ=", "key123");
        System.out.println(plainText);

        return "redirect:/dashboard";
    }

}

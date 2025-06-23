package com.sc.ddd.unusualSpends.service;

import com.sc.ddd.unusualSpends.DTO.UnusualSpend;

import java.util.List;

public interface Formatter {
    String formatMessage(List<UnusualSpend> unusualSpends, String firstName);

}

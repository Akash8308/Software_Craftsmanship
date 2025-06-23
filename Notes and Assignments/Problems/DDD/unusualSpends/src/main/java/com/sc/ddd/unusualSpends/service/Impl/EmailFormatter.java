package com.sc.ddd.unusualSpends.service.Impl;

import com.sc.ddd.unusualSpends.DTO.UnusualSpend;
import com.sc.ddd.unusualSpends.service.Communicator;

import java.util.List;
import java.util.logging.Formatter;

    public class EmailFormatter implements Formatter {
    @Override
    public String formatMessage(List<UnusualSpend> unusualSpends, String firstName) {
        StringBuilder stringBuilder =  new StringBuilder();

        var totalUnusualSpend = unusualSpends.stream().mapToDouble(UnusualSpend::getAmount).sum();

        stringBuilder.append("Unusual spending of ₹").append(totalUnusualSpend).append(" detected!\n");
        blankLine(stringBuilder);
        stringBuilder.append("Hello ").append(firstName).append("!\n");
        blankLine(stringBuilder);
        stringBuilder.append("We have detected unusually high spending on your card in these categories:\n");
        blankLine(stringBuilder);

        for (UnusualSpend unusualSpend: unusualSpends) {
            blankLine(stringBuilder.append("* You spent ₹").append(unusualSpend.getAmount()).append(" on ").append(unusualSpend.getCategory()));
        }

        blankLine(stringBuilder);
        stringBuilder.append("Thanks,\n");
        blankLine(stringBuilder);
        stringBuilder.append("The Credit Card Company");

        return stringBuilder.toString();
    }

    private static void blankLine(StringBuilder stringBuilder) {
        stringBuilder.append("\n");
    }
}

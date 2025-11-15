package com.borsibaar.dto;

import java.math.BigDecimal;

public record StationSalesStatsResponseDto(
                Long barStationId,
                String barStationName,
                Long salesCount,
                BigDecimal totalRevenue) {
}


package com.checkin.app.checkin.manager.models

import com.checkin.app.checkin.menu.models.MenuItemBriefModel
import com.checkin.app.checkin.utility.Utils
import com.fasterxml.jackson.annotation.JsonProperty

data class ManagerStatsModel(
        val revenue: StatsDuration,
        @JsonProperty("count_orders") val countOrders: StatsDuration,
        @JsonProperty("avg_session_time") val avgSessionTime: Long,
        @JsonProperty("avg_serving_time") val avgServingTime: Long,
        @JsonProperty("avg_acceptance_time") val avgOrderAcceptanceTime: Long,
        @JsonProperty("trending_orders") val trendingItems: List<ItemRevenue>,
        @JsonProperty("poor_orders") val poorItems: List<ItemRevenue>,
        @JsonProperty("trending_groups") val trendingGroups: List<GroupRevenue>
) {
    fun formatAvgSessionTime(): String = Utils.formatTimeDuration(avgSessionTime)

    fun formatAvgServingTime(): String = Utils.formatTimeDuration(avgServingTime)

    fun formatOrderAcceptingTime(): String = Utils.formatTimeDuration(avgOrderAcceptanceTime)

    data class ItemRevenue(val item: MenuItemBriefModel) {
        @JsonProperty("revenue_contribution")
        var revenueContribution = 0.0
            get() = field * 100
    }

    data class GroupRevenue(val group: String) {
        @JsonProperty("revenue_contribution")
        var revenueContribution = 0.0
            get() = field * 100
    }

    data class StatsDuration(
            val live: Double,
            val day: Double,
            val yesterday: Double,
            val week: Double
    )
}
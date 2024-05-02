package com.eshc.goonersapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.eshc.goonersapp.navigation.TopLevelDestination
import com.eshc.goonersapp.ui.GnrTopLevelBar
import org.junit.Rule
import org.junit.Test

/**
 * Created by KanuKim97
 *
 * GnrTopLevelBarSimpleUiTest
 *  - This test is Compose Simple UI Test (GnrTopLevelBar)
 *  - this test use only 2 test rules (finder & assertion)
 *  - This application hav 3 top level (home, team, match)
 *  - Check Each TopLevelDestination name on TopAppbar Text Composable
 *
 * TestRule
 *
 * composeTestRule have 3 test rules
 *  1. {.finder}
 *  2. {.assertion}
 *  3. {.action} - not used in this test
 */
class GnrTopLevelBarSimpleUiTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun gnrTopAppbar_assert_display_home() {
        composeTestRule.setContent {
            GnrTopLevelBar(
                topLevelDestination = TopLevelDestination.HOME,
                icons = {  }
            )
        }

        composeTestRule
            .onNodeWithText(TopLevelDestination.HOME.name)
            .assertIsDisplayed()
    }

    @Test
    fun gnrTopAppbar_assert_display_team() {
        composeTestRule.setContent {
            GnrTopLevelBar(
                topLevelDestination = TopLevelDestination.TEAM,
                icons = {  }
            )
        }

        composeTestRule
            .onNodeWithText(TopLevelDestination.TEAM.name)
            .assertIsDisplayed()
    }

    @Test
    fun gnrTopAppbar_assert_display_match() {
        composeTestRule.setContent {
            GnrTopLevelBar(
                topLevelDestination = TopLevelDestination.MATCH,
                icons = {  }
            )
        }

        composeTestRule
            .onNodeWithText(TopLevelDestination.MATCH.name)
            .assertIsDisplayed()
    }
}
package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.bidcommands.AddBidCommand;
import seedu.address.logic.commands.bidcommands.DeleteBidCommand;
import seedu.address.logic.commands.bidcommands.EditBidCommand;
import seedu.address.logic.commands.bidcommands.FindBidCommand;
import seedu.address.logic.commands.bidcommands.ListBidCommand;
import seedu.address.logic.commands.biddercommands.AddBidderCommand;
import seedu.address.logic.commands.biddercommands.DeleteBidderCommand;
import seedu.address.logic.commands.biddercommands.EditBidderCommand;
import seedu.address.logic.commands.biddercommands.FindBidderCommand;
import seedu.address.logic.commands.biddercommands.ListBidderCommand;
import seedu.address.logic.commands.calendarnavigation.NextCalendarNavigationCommand;
import seedu.address.logic.commands.calendarnavigation.PrevCalendarNavigationCommand;
import seedu.address.logic.commands.meetingcommands.AddMeetingCommand;
import seedu.address.logic.commands.meetingcommands.DeleteMeetingCommand;
import seedu.address.logic.commands.meetingcommands.EditMeetingCommand;
import seedu.address.logic.commands.meetingcommands.FindMeetingCommand;
import seedu.address.logic.commands.meetingcommands.ListMeetingCommand;
import seedu.address.logic.commands.meetingcommands.SortMeetingCommand;
import seedu.address.logic.commands.property.AddPropertyCommand;
import seedu.address.logic.commands.property.DeletePropertyCommand;
import seedu.address.logic.commands.property.EditPropertyCommand;
import seedu.address.logic.commands.property.FindPropertyCommand;
import seedu.address.logic.commands.property.ListPropertyCommand;
import seedu.address.logic.commands.sellercommands.AddSellerCommand;
import seedu.address.logic.commands.sellercommands.DeleteSellerCommand;
import seedu.address.logic.commands.sellercommands.EditSellerCommand;
import seedu.address.logic.commands.sellercommands.FindSellerCommand;
import seedu.address.logic.commands.sellercommands.ListSellerCommand;
import seedu.address.logic.parser.bidderparser.AddBidderCommandParser;
import seedu.address.logic.parser.bidderparser.DeleteBidderCommandParser;
import seedu.address.logic.parser.bidderparser.EditBidderCommandParser;
import seedu.address.logic.parser.bidderparser.FindBidderCommandParser;
import seedu.address.logic.parser.bidparser.AddBidCommandParser;
import seedu.address.logic.parser.bidparser.DeleteBidCommandParser;
import seedu.address.logic.parser.bidparser.EditBidCommandParser;
import seedu.address.logic.parser.bidparser.FindBidCommandParser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.logic.parser.meetingparser.AddMeetingCommandParser;
import seedu.address.logic.parser.meetingparser.DeleteMeetingCommandParser;
import seedu.address.logic.parser.meetingparser.EditMeetingCommandParser;
import seedu.address.logic.parser.meetingparser.FindMeetingCommandParser;
import seedu.address.logic.parser.meetingparser.SortMeetingCommandParser;
import seedu.address.logic.parser.property.AddPropertyCommandParser;
import seedu.address.logic.parser.property.DeletePropertyCommandParser;
import seedu.address.logic.parser.property.EditPropertyCommandParser;
import seedu.address.logic.parser.property.FindPropertyCommandParser;
import seedu.address.logic.parser.sellerparser.AddSellerCommandParser;
import seedu.address.logic.parser.sellerparser.DeleteSellerCommandParser;
import seedu.address.logic.parser.sellerparser.EditSellerCommandParser;
import seedu.address.logic.parser.sellerparser.FindSellerCommandParser;

/**
 * Parses user input.
 */
public class AddressBookParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());

        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");

        switch (commandWord) {

        // ------------------ MISC -------------------- //

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        // -------------------- BID ------------------- //
        case AddBidCommand.COMMAND_WORD:
            return new AddBidCommandParser().parse(arguments);

        case ListBidCommand.COMMAND_WORD:
            return new ListBidCommand();

        case DeleteBidCommand.COMMAND_WORD:
            return new DeleteBidCommandParser().parse(arguments);

        case EditBidCommand.COMMAND_WORD:
            return new EditBidCommandParser().parse(arguments);

        case FindBidCommand.COMMAND_WORD:
            return new FindBidCommandParser().parse(arguments);

        // -------------------- MEETING ------------------- //
        case AddMeetingCommand.COMMAND_WORD:
            return new AddMeetingCommandParser().parse(arguments);

        case DeleteMeetingCommand.COMMAND_WORD:
            return new DeleteMeetingCommandParser().parse(arguments);

        case EditMeetingCommand.COMMAND_WORD:
            return new EditMeetingCommandParser().parse(arguments);

        case ListMeetingCommand.COMMAND_WORD:
            return new ListMeetingCommand();

        case FindMeetingCommand.COMMAND_WORD:
            return new FindMeetingCommandParser().parse(arguments);

        case SortMeetingCommand.COMMAND_WORD:
            return new SortMeetingCommandParser().parse(arguments);

        // -------------------- PROPERTY ------------------- //
        case AddPropertyCommand.COMMAND_WORD:
            return new AddPropertyCommandParser().parse(arguments);

        case DeletePropertyCommand.COMMAND_WORD:
            return new DeletePropertyCommandParser().parse(arguments);

        case ListPropertyCommand.COMMAND_WORD:
            return new ListPropertyCommand();

        case EditPropertyCommand.COMMAND_WORD:
            return new EditPropertyCommandParser().parse(arguments);

        case FindPropertyCommand.COMMAND_WORD:
            return new FindPropertyCommandParser().parse(arguments);

        // -------------------- BIDDER ------------------- //
        case AddBidderCommand.COMMAND_WORD:
            return new AddBidderCommandParser().parse(arguments);

        case ListBidderCommand.COMMAND_WORD:
            return new ListBidderCommand();

        case DeleteBidderCommand.COMMAND_WORD:
            return new DeleteBidderCommandParser().parse(arguments);

        case FindBidderCommand.COMMAND_WORD:
            return new FindBidderCommandParser().parse(arguments);

        case EditBidderCommand.COMMAND_WORD:
            return new EditBidderCommandParser().parse(arguments);

        // -------------------- SELLER ------------------- //

        case AddSellerCommand.COMMAND_WORD:
            return new AddSellerCommandParser().parse(arguments);

        case ListSellerCommand.COMMAND_WORD:
            return new ListSellerCommand();

        case DeleteSellerCommand.COMMAND_WORD:
            return new DeleteSellerCommandParser().parse(arguments);

        case FindSellerCommand.COMMAND_WORD:
            return new FindSellerCommandParser().parse(arguments);

        case EditSellerCommand.COMMAND_WORD:
            return new EditSellerCommandParser().parse(arguments);

        // ----------------- CALENDAR NAVIGATION ------------ //
        case NextCalendarNavigationCommand.COMMAND_WORD:
            return new NextCalendarNavigationCommand();

        case PrevCalendarNavigationCommand.COMMAND_WORD:
            return new PrevCalendarNavigationCommand();

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}

package com.epochalypse.hmgit.commandhandler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CommandHandlerFactoryTest {

    static Stream<Arguments> testArgs() {
        //Case 1: Empty arguments
        String[] args1 = new String[0];
        Class<? extends CommandHandler> class1 = HelpCommandHandler.class;

        //Case 2: Help argument
        String[] args2 = new String[]{ HelpCommandHandler.COMMAND_NAME };
        Class<? extends CommandHandler> class2 = HelpCommandHandler.class;

        //Case 3: Init argument
        String[] args3 = new String[]{ InitCommandHandler.COMMAND_NAME };
        Class<? extends CommandHandler> class3 = InitCommandHandler.class;

        //Case 4: Cat File argument
        String[] args4 = new String[]{ CatFileCommandHandler.COMMAND_NAME };
        Class<? extends CommandHandler> class4 = CatFileCommandHandler.class;

        //Case 5: Hash Object argument
        String[] args5 = new String[]{ HashObjectCommandHandler.COMMAND_NAME };
        Class<? extends CommandHandler> class5 = HashObjectCommandHandler.class;

        return Stream.of(
                Arguments.of( args1, class1 ),
                Arguments.of( args2, class2 ),
                Arguments.of( args3, class3 ),
                Arguments.of( args4, class4 ),
                Arguments.of( args5, class5 )
        );
    }

    @ParameterizedTest
    @MethodSource( "testArgs" )
    void testGetCommandHandler( String[] args, Class<? extends CommandHandler> expectedClass ) {
        CommandHandler handler = CommandHandlerFactory.getCommandHandler( args );
        Assertions.assertEquals( expectedClass, handler.getClass() );
    }

}

package ru.ponomarev.teammanager.domain.interactors;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import ru.ponomarev.teammanager.data.threading.MainThreadImplTest;
import ru.ponomarev.teammanager.domain.entity.Game;
import ru.ponomarev.teammanager.domain.executor.IExecutor;
import ru.ponomarev.teammanager.domain.executor.IMainThread;
import ru.ponomarev.teammanager.domain.interactors.impl.ListGamesInteractorImpl;
import ru.ponomarev.teammanager.domain.repository.IGamesRepository;
import ru.ponomarev.teammanager.utils.GameEntitiesGenerator;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * @author Пономарев Андрей
 */
public class ListGamesInteractorImplTest {

    private IMainThread mMainThread;

    @Mock
    private IExecutor mExecutor;
    @Mock
    private IListGamesInteractor.Callback mCallback;
    @Mock
    private IGamesRepository mGamesRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mMainThread = new MainThreadImplTest();
    }

    @Test
    public void testFilledListGames() throws Exception {

        List<Game> gamesList = GameEntitiesGenerator.createRandomGamesList(true);

        when(mGamesRepository.getAll()).thenReturn(gamesList);

        ListGamesInteractorImpl interactor = new ListGamesInteractorImpl(
                mExecutor,
                mMainThread,
                mCallback,
                mGamesRepository
        );
        interactor.run();

        verify(mGamesRepository).getAll();
        verifyNoMoreInteractions(mGamesRepository);
        verify(mCallback).showGamesList(gamesList);
        verifyNoMoreInteractions(mCallback);
    }


    @Test
    public void testBlankGamesList() throws Exception {


        when(mGamesRepository.getAll()).thenReturn(null);

        ListGamesInteractorImpl interactor = new ListGamesInteractorImpl(
                mExecutor,
                mMainThread,
                mCallback,
                mGamesRepository
        );
        interactor.run();

        verify(mGamesRepository).getAll();
        verifyNoMoreInteractions(mGamesRepository);
        verify(mCallback).showBlankWindow();
        verifyNoMoreInteractions(mCallback);
    }
}
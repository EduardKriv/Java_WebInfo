CREATE TABLE Peers (
        nickname varchar UNIQUE primary key,
        birthday date not null
);

CREATE TABLE Tasks (
        title varchar primary key UNIQUE DEFAULT NULL,
        parentTask varchar DEFAULT NULL, constraint FK_Tasks_ParentTask foreign key (title) references Tasks(title),
        maxXP integer not null
);

CREATE TYPE check_status AS ENUM ('Start', 'Success', 'Failure');

CREATE TABLE Checks (
        id serial primary key,
        peer varchar, constraint fk_Checks_checkingPeer foreign key (peer) references Peers(nickname),
        task varchar, constraint fk_Checks_Peer_title foreign key (task) references Tasks(title),
        "date" date
);

CREATE TABLE P2P (
        id serial primary key,
        "check" bigint, constraint fk_P2P_check foreign key ("check") references Checks(id),
        checkingPeer varchar, constraint fk_P2P_checkingPeer foreign key (checkingPeer) references Peers(nickname),
        state check_status,
        "time" TIME without time zone
);

CREATE TABLE Verter (
        id serial primary key,
        "check" bigint, constraint fk_Verter_check foreign key ("check") references Checks(id),
        state check_status,
        "time" TIME without time zone
);

CREATE TABLE TransferredPoints (
        id serial primary key,
        checkingPeer varchar, constraint fk_TransferredPoints_checkingPeer foreign key (checkingPeer) references Peers(nickname),
        checkedPeer varchar, constraint fk_TransferredPoints_checkedPeer foreign key (checkedPeer) references Peers(nickname),
        pointsAmount integer
);

CREATE TABLE Friends (
        id serial primary key,
        peer1 varchar not null, constraint fk_Friends_Peer1 foreign key (peer1) references Peers(nickname),
        peer2 varchar not null, constraint fk_Friends_Peer2 foreign key (peer2) references Peers(nickname)
);

CREATE TABLE Recommendations (
        id serial primary key,
        peer varchar, constraint fk_Recommendations_Peer foreign key (peer) references Peers(nickname),
        recommendedPeer varchar, constraint fk_Recommendations_RecommendedPeer foreign key (recommendedPeer) references Peers(nickname)
);

CREATE TABLE XP (
        id serial primary key,
        "check" bigint, constraint fk_XP_check foreign key ("check") references Checks(id),
        xpAmount integer
);

CREATE TYPE time_status AS ENUM ('1', '2');

CREATE TABLE TimeTracking (
        id serial primary key,
        peer varchar, constraint fk_TimeTracking_Peer foreign key (peer) references Peers(nickname),
        "date" date,
        "time" TIME without time zone,
        state time_status
);

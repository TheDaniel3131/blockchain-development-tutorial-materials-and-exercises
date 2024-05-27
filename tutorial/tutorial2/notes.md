```solidity
// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.24;

// https://www.epochconverter.com/
// Uncomment this line to use console.log
// import "hardhat/console.sol";

contract Lock {
    uint public unlockTime;
    address payable public owner;

    event Withdrawal(uint amount, uint when);

    constructor(uint _unlockTime) payable {
        require(
            block.timestamp < _unlockTime,
            "Unlock time should be in the future"
        );

        unlockTime = _unlockTime;
        owner = payable(msg.sender);
    }

    function withdraw() public {
        // Uncomment this line, and the import of "hardhat/console.sol", to print a log in your terminal
        // console.log("Unlock time is %o and block timestamp is %o", unlockTime, block.timestamp);

        require(block.timestamp >= unlockTime, "You can't withdraw yet");
        require(msg.sender == owner, "You aren't the owner");

        emit Withdrawal(address(this).balance, block.timestamp);

        owner.transfer(address(this).balance);
    }

    function getCurrentTime() public view returns (uint256) {
        uint256 currentTime = block.timestamp;
        return currentTime;
    }
}
```

![image](https://github.com/TheDaniel3131/blockchain-development-tutorial-materials-and-exercises/assets/71692327/c4e95580-4a99-41a1-b0cb-93e8914df57f)

![image](https://github.com/TheDaniel3131/blockchain-development-tutorial-materials-and-exercises/assets/71692327/b075c215-3531-48f6-9eca-e5e9e11e5a77)


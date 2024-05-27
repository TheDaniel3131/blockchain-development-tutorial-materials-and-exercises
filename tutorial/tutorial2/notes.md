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


```powershell
Windows PowerShell
Copyright (C) Microsoft Corporation. All rights reserved.

Install the latest PowerShell for new features and improvements! https://aka.ms/PSWindows

PS D:\Project_2024\hardhat_tutorial_new> cd test
PS D:\Project_2024\hardhat_tutorial_new\test> npx hardhat test
Error HH801: Plugin @nomicfoundation/hardhat-toolbox-viem requires the following dependencies to be installed: @nomicfoundation/hardhat-ignition-viem, @nomicfoundation/hardhat-network-helpers, @nomicfoundation/hardhat-verify, @nomicfoundation/hardhat-viem, @types/chai, @types/chai-as-promised, @types/mocha, chai, hardhat-gas-reporter, solidity-coverage, viem.
Please run: npm install --save-dev "@nomicfoundation/hardhat-ignition-viem@^0.15.0" "@nomicfoundation/hardhat-network-helpers@^1.0.0" "@nomicfoundation/hardhat-verify@^2.0.0" "@nomicfoundation/hardhat-viem@^2.0.0" "@types/chai@^4.2.0" "@types/chai-as-promised@^7.1.6" "@types/mocha@>=9.1.0" "chai@^4.2.0" "hardhat-gas-reporter@^1.0.8" "solidity-coverage@^0.8.1" "viem@^2.7.6"

For more info go to https://hardhat.org/HH801 or run Hardhat with --show-stack-traces
PS D:\Project_2024\hardhat_tutorial_new\test> npx hardhat --show-stack-traces
Error HH801: Plugin @nomicfoundation/hardhat-toolbox-viem requires the following dependencies to be installed: @nomicfoundation/hardhat-ignition-viem, @nomicfoundation/hardhat-network-helpers, @nomicfoundation/hardhat-verify, @nomicfoundation/hardhat-viem, @types/chai, @types/chai-as-promised, @types/mocha, chai, hardhat-gas-reporter, solidity-coverage, viem.
Please run: npm install --save-dev "@nomicfoundation/hardhat-ignition-viem@^0.15.0" "@nomicfoundation/hardhat-network-helpers@^1.0.0" "@nomicfoundation/hardhat-verify@^2.0.0" "@nomicfoundation/hardhat-viem@^2.0.0" "@types/chai@^4.2.0" "@types/chai-as-promised@^7.1.6" "@types/mocha@>=9.1.0" "chai@^4.2.0" "hardhat-gas-reporter@^1.0.8" "solidity-coverage@^0.8.1" "viem@^2.7.6"

HardhatError: HH801: Plugin @nomicfoundation/hardhat-toolbox-viem requires the following dependencies to be installed: @nomicfoundation/hardhat-ignition-viem, @nomicfoundation/hardhat-network-helpers, @nomicfoundation/hardhat-verify, @nomicfoundation/hardhat-viem, @types/chai, @types/chai-as-promised, @types/mocha, chai, hardhat-gas-reporter, solidity-coverage, viem.
Please run: npm install --save-dev "@nomicfoundation/hardhat-ignition-viem@^0.15.0" "@nomicfoundation/hardhat-network-helpers@^1.0.0" "@nomicfoundation/hardhat-verify@^2.0.0" "@nomicfoundation/hardhat-viem@^2.0.0" "@types/chai@^4.2.0" "@types/chai-as-promised@^7.1.6" "@types/mocha@>=9.1.0" "chai@^4.2.0" "hardhat-gas-reporter@^1.0.8" "solidity-coverage@^0.8.1" "viem@^2.7.6"
    at analyzeModuleNotFoundError (D:\Project_2024\hardhat_tutorial_new\node_modules\hardhat\src\internal\core\config\config-loading.ts:233:11)
    at loadConfigAndTasks (D:\Project_2024\hardhat_tutorial_new\node_modules\hardhat\src\internal\core\config\config-loading.ts:97:5)
    at main (D:\Project_2024\hardhat_tutorial_new\node_modules\hardhat\src\internal\cli\cli.ts:218:62)
    at Object.<anonymous> (D:\Project_2024\hardhat_tutorial_new\node_modules\hardhat\src\internal\cli\cli.ts:474:1)
    at Module._compile (node:internal/modules/cjs/loader:1376:14)
    at Object.Module._extensions..js (node:internal/modules/cjs/loader:1435:10)
    at Module.load (node:internal/modules/cjs/loader:1207:32)
    at Function.Module._load (node:internal/modules/cjs/loader:1023:12)
    at Module.require (node:internal/modules/cjs/loader:1235:19)
    at require (node:internal/modules/helpers:176:18)
PS D:\Project_2024\hardhat_tutorial_new\test> npm install --save-dev "@nomicfoundation/hardhat-ignition-viem@^0.15.0" "@nomicfoundation/hardhat-network-helpers@^1.0.0" "@nomicfoundation/hardhat-verify@^2.0.0" "@nomicfoundation/hardhat-viem@^2.0.0" "@types/chai@^4.2.0" "@types/chai-as-promised@^7.1.6" "@types/mocha@>=9.1.0" "chai@^4.2.0" "hardhat-gas-reporter@^1.0.8" "solidity-coverage@^0.8.1" "viem@^2.7.6"
npm WARN deprecated glob@5.0.15: Glob versions prior to v9 are no longer supported
npm WARN deprecated glob@7.1.3: Glob versions prior to v9 are no longer supported
npm WARN deprecated debug@3.2.6: Debug versions >=3.2.0 <3.2.7 || >=4 <4.3.1 have a low-severity ReDos regression when used in a Node.js environment. It is recommended you upgrade to 3.2.7 or 4.3.1. (https://github.com/visionmedia/debug/issues/797)
PS D:\Project_2024\hardhat_tutorial_new\test> npx hardhat test
Error HH801: Plugin @nomicfoundation/hardhat-ignition-viem requires the following dependencies to be installed: @nomicfoundation/hardhat-ignition, @nomicfoundation/ignition-core.
Please run: npm install --save-dev "@nomicfoundation/hardhat-ignition@^0.15.0" "@nomicfoundation/ignition-core@^0.15.0"

For more info go to https://hardhat.org/HH801 or run Hardhat with --show-stack-traces
PS D:\Project_2024\hardhat_tutorial_new\test> npm install --save-dev "@nomicfoundation/hardhat-ignition@^0.15.0" "@nomicfoundation/ignition-core@^0.15.0"

added 32 packages, and audited 652 packages in 11s

142 packages are looking for funding
  run `npm fund` for details

8 vulnerabilities (1 low, 1 high, 6 critical)

To address all issues, run:
  npm audit fix

Run `npm audit` for details.
PS D:\Project_2024\hardhat_tutorial_new\test> npx hardhat test
Downloading compiler 0.8.24
Compiled 1 Solidity file successfully (evm target: paris).


  Lock
    Deployment
      ✔ Should set the right unlockTime (1187ms)
      ✔ Should set the right owner
      ✔ Should receive and store the funds to lock
      ✔ Should fail if the unlockTime is not in the future
    Withdrawals
      Validations
        ✔ Should revert with the right error if called too soon
        ✔ Should revert with the right error if called from another account
        ✔ Shouldn't fail if the unlockTime has arrived and the owner calls it
      Events
        ✔ Should emit an event on withdrawals


  8 passing (1s)

PS D:\Project_2024\hardhat_tutorial_new\test> REPORT_GAS=true npx hardhat test
REPORT_GAS=true : The term 'REPORT_GAS=true' is not recognized as the name of a cmdlet, function, script file, or operable program. Check the spelling of
the name, or if a path was included, verify that the path is correct and try again.
At line:1 char:1
+ REPORT_GAS=true npx hardhat test
+ ~~~~~~~~~~~~~~~
    + CategoryInfo          : ObjectNotFound: (REPORT_GAS=true:String) [], CommandNotFoundException
    + FullyQualifiedErrorId : CommandNotFoundException

PS D:\Project_2024\hardhat_tutorial_new\test> cd /test/Lock.ts
cd : Cannot find path 'D:\test\Lock.ts' because it does not exist.
At line:1 char:1
+ cd /test/Lock.ts
+ ~~~~~~~~~~~~~~~~
    + CategoryInfo          : ObjectNotFound: (D:\test\Lock.ts:String) [Set-Location], ItemNotFoundException
    + FullyQualifiedErrorId : PathNotFound,Microsoft.PowerShell.Commands.SetLocationCommand

PS D:\Project_2024\hardhat_tutorial_new\test> cd test
cd : Cannot find path 'D:\Project_2024\hardhat_tutorial_new\test\test' because it does not exist.
At line:1 char:1
+ cd test
+ ~~~~~~~
    + CategoryInfo          : ObjectNotFound: (D:\Project_2024...l_new\test\test:String) [Set-Location], ItemNotFoundException
    + FullyQualifiedErrorId : PathNotFound,Microsoft.PowerShell.Commands.SetLocationCommand

PS D:\Project_2024\hardhat_tutorial_new\test> cd "Lock.ts"
cd : Cannot find path 'Lock.ts' because it does not exist.
At line:1 char:1
+ cd "Lock.ts"
+ ~~~~~~~~~~~~
    + CategoryInfo          : ObjectNotFound: (Lock.ts:String) [Set-Location], ItemNotFoundException
    + FullyQualifiedErrorId : PathNotFound,Microsoft.PowerShell.Commands.SetLocationCommand

PS D:\Project_2024\hardhat_tutorial_new\test> cd "D:\Project_2024\hardhat_tutorial_new\test"
PS D:\Project_2024\hardhat_tutorial_new\test> npx hardhat test


  Lock
    Deployment
      ✔ Should set the right unlockTime (1163ms)
      ✔ Should set the right owner
      ✔ Should receive and store the funds to lock
      ✔ Should fail if the unlockTime is not in the future
    Withdrawals
      Validations
        ✔ Should revert with the right error if called too soon
        ✔ Should revert with the right error if called from another account
        ✔ Shouldn't fail if the unlockTime has arrived and the owner calls it
      Events
        ✔ Should emit an event on withdrawals


  8 passing (1s)

PS D:\Project_2024\hardhat_tutorial_new\test> $env:REPORT_GAS="true"; npx hardhat test

  Lock
    Deployment
      ✔ Should set the right unlockTime
      ✔ Should set the right owner
      ✔ Should receive and store the funds to lock
      ✔ Should fail if the unlockTime is not in the future
    Withdrawals
      Validations
        ✔ Should revert with the right error if called too soon
        ✔ Should revert with the right error if called from another account
        ✔ Shouldn't fail if the unlockTime has arrived and the owner calls it
      Events
        ✔ Should emit an event on withdrawals

·------------------------|----------------------------|-------------|-----------------------------·
|  Solc version: 0.8.24  ·  Optimizer enabled: false  ·  Runs: 200  ·  Block limit: 30000000 gas  │
·························|····························|·············|······························
|  Methods                                                                                        │
··············|··········|··············|·············|·············|···············|··············
|  Contract   ·  Method  ·  Min         ·  Max        ·  Avg        ·  # calls      ·  usd (avg)  │
··············|··········|··············|·············|·············|···············|··············
|  Deployments           ·                                          ·  % of limit   ·             │
·························|··············|·············|·············|···············|··············
|  Lock                  ·           -  ·          -  ·     326112  ·        1.1 %  ·          -  │
·------------------------|--------------|-------------|-------------|---------------|-------------·

  8 passing (1s)

PS D:\Project_2024\hardhat_tutorial_new\test> npx hardhat node
Started HTTP and WebSocket JSON-RPC server at http://127.0.0.1:8545/

Accounts
========

WARNING: These accounts, and their private keys, are publicly known.
Any funds sent to them on Mainnet or any other live network WILL BE LOST.

Account #0: 0xf39Fd6e51aad88F6F4ce6aB8827279cffFb92266 (10000 ETH)
Private Key: 0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80

Account #1: 0x70997970C51812dc3A010C7d01b50e0d17dc79C8 (10000 ETH)
Private Key: 0x59c6995e998f97a5a0044966f0945389dc9e86dae88c7a8412f4603b6b78690d

Account #2: 0x3C44CdDdB6a900fa2b585dd299e03d12FA4293BC (10000 ETH)
Private Key: 0x5de4111afa1a4b94908f83103eb1f1706367c2e68ca870fc3fb9a804cdab365a

Account #3: 0x90F79bf6EB2c4f870365E785982E1f101E93b906 (10000 ETH)
Private Key: 0x7c852118294e51e653712a81e05800f419141751be58f605c371e15141b007a6

Account #4: 0x15d34AAf54267DB7D7c367839AAf71A00a2C6A65 (10000 ETH)
Private Key: 0x47e179ec197488593b187f80a00eb0da91f1b9d0b13f8733639f19c30a34926a

Account #5: 0x9965507D1a55bcC2695C58ba16FB37d819B0A4dc (10000 ETH)
Private Key: 0x8b3a350cf5c34c9194ca85829a2df0ec3153be0318b5e2d3348e872092edffba

Account #6: 0x976EA74026E726554dB657fA54763abd0C3a0aa9 (10000 ETH)
Private Key: 0x92db14e403b83dfe3df233f83dfa3a0d7096f21ca9b0d6d6b8d88b2b4ec1564e

Account #7: 0x14dC79964da2C08b23698B3D3cc7Ca32193d9955 (10000 ETH)
Private Key: 0x4bbbf85ce3377467afe5d46f804f221813b2bb87f24d81f60f1fcdbf7cbf4356

Account #8: 0x23618e81E3f5cdF7f54C3d65f7FBc0aBf5B21E8f (10000 ETH)
Private Key: 0xdbda1821b80551c9d65939329250298aa3472ba22feea921c0cf5d620ea67b97

Account #9: 0xa0Ee7A142d267C1f36714E4a8F75612F20a79720 (10000 ETH)
Private Key: 0x2a871d0798f97d79848a013d4936a73bf4cc922c825d33c1cf7073dff6d409c6

Account #10: 0xBcd4042DE499D14e55001CcbB24a551F3b954096 (10000 ETH)
Private Key: 0xf214f2b2cd398c806f84e317254e0f0b801d0643303237d97a22a48e01628897

Account #11: 0x71bE63f3384f5fb98995898A86B02Fb2426c5788 (10000 ETH)
Private Key: 0x701b615bbdfb9de65240bc28bd21bbc0d996645a3dd57e7b12bc2bdf6f192c82

Account #12: 0xFABB0ac9d68B0B445fB7357272Ff202C5651694a (10000 ETH)
Private Key: 0xa267530f49f8280200edf313ee7af6b827f2a8bce2897751d06a843f644967b1

Account #13: 0x1CBd3b2770909D4e10f157cABC84C7264073C9Ec (10000 ETH)
Private Key: 0x47c99abed3324a2707c28affff1267e45918ec8c3f20b8aa892e8b065d2942dd

Account #14: 0xdF3e18d64BC6A983f673Ab319CCaE4f1a57C7097 (10000 ETH)
Private Key: 0xc526ee95bf44d8fc405a158bb884d9d1238d99f0612e9f33d006bb0789009aaa

Account #15: 0xcd3B766CCDd6AE721141F452C550Ca635964ce71 (10000 ETH)
Private Key: 0x8166f546bab6da521a8369cab06c5d2b9e46670292d85c875ee9ec20e84ffb61

Account #16: 0x2546BcD3c84621e976D8185a91A922aE77ECEc30 (10000 ETH)
Private Key: 0xea6c44ac03bff858b476bba40716402b03e41b8e97e276d1baec7c37d42484a0

Account #17: 0xbDA5747bFD65F08deb54cb465eB87D40e51B197E (10000 ETH)
Private Key: 0x689af8efa8c651a91ad287602527f3af2fe9f6501a7ac4b061667b5a93e037fd

Account #18: 0xdD2FD4581271e230360230F9337D5c0430Bf44C0 (10000 ETH)
Private Key: 0xde9be858da4a475276426320d5e9262ecfc3ba460bfac56360bfa6c4c28b4ee0

Account #19: 0x8626f6940E2eb28930eFb4CeF49B2d1F2C9C1199 (10000 ETH)
Private Key: 0xdf57089febbacf7ba0bc227dafbffa9fc08a93fdc68e1e42411a14efcf23656e

WARNING: These accounts, and their private keys, are publicly known.
Any funds sent to them on Mainnet or any other live network WILL BE LOST.

```


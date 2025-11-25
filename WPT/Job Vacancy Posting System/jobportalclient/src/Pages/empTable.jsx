import React from "react";
import {
  Disclosure,
  DisclosureButton,
  DisclosurePanel,
  Menu,
  MenuButton,
  MenuItem,
  MenuItems,
} from "@headlessui/react";
import { Bars3Icon, XMarkIcon, BellIcon } from "@heroicons/react/24/outline";

const navigation = [
  { name: "Dashboard", href: "#", current: true },
  { name: "Jobs", href: "#", current: false },
  { name: "Applications", href: "#", current: false },
  { name: "Employees", href: "#", current: false },
];

function classNames(...classes) {
  return classes.filter(Boolean).join(" ");
}

export default function EmpTable() {
  return (
    <>
      <Disclosure as="nav" className="bg-gray-800">
        <div className="mx-auto max-w-7xl px-4">
          <div className="flex h-14 items-center justify-between">

            {/* Mobile Menu Button */}
            <div className="flex items-center sm:hidden">
              <DisclosureButton className="rounded-md p-2 text-gray-300 hover:bg-gray-700 hover:text-white">
                <Bars3Icon className="block size-5 group-data-open:hidden" />
                <XMarkIcon className="hidden size-5 group-data-open:block" />
              </DisclosureButton>
            </div>

            {/* Logo + Navigation */}
            <div className="flex flex-1 items-center">
              <div className="flex items-center">
                <img
                  alt="Logo"
                  src="https://tailwindcss.com/plus-assets/img/logos/mark.svg"
                  className="h-6 w-auto"
                />
              </div>

              <div className="hidden sm:block sm:ml-6">
                <div className="flex space-x-4">
                  {navigation.map((item) => (
                    <a
                      key={item.name}
                      href={item.href}
                      className={classNames(
                        item.current
                          ? "bg-gray-900 text-white"
                          : "text-gray-300 hover:bg-gray-700 hover:text-white",
                        "px-3 py-1 rounded-md text-sm"
                      )}
                    >
                      {item.name}
                    </a>
                  ))}
                </div>
              </div>
            </div>

            {/* Right Side */}
            <div className="flex items-center">
              <button className="p-1 text-gray-300 hover:text-white">
                <BellIcon className="size-5" />
              </button>

              <Menu as="div" className="relative ml-3">
                <MenuButton>
                  <img
                    className="h-8 w-8 rounded-full"
                    src="https://images.unsplash.com/photo-1472099645785-5658abf4ff4e"
                    alt="User"
                  />
                </MenuButton>

                <MenuItems className="absolute right-0 mt-2 w-40 rounded-md bg-gray-800 shadow-lg p-1">
                  <MenuItem>
                    <a className="block px-3 py-1 text-sm text-gray-300 hover:bg-gray-700">
                      Profile
                    </a>
                  </MenuItem>
                  <MenuItem>
                    <a className="block px-3 py-1 text-sm text-gray-300 hover:bg-gray-700">
                      Logout
                    </a>
                  </MenuItem>
                </MenuItems>
              </Menu>
            </div>
          </div>
        </div>

        {/* Mobile Menu */}
        <DisclosurePanel className="sm:hidden px-4 pb-3">
          {navigation.map((item) => (
            <DisclosureButton
              key={item.name}
              as="a"
              href={item.href}
              className="block px-3 py-2 rounded-md text-base text-gray-300 hover:bg-gray-700 hover:text-white"
            >
              {item.name}
            </DisclosureButton>
          ))}
        </DisclosurePanel>
      </Disclosure>

      <div className="p-6">
        <h2 className="text-xl font-semibold">Employee Table</h2>
      </div>
    </>
  );
}
